package medium;
//在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
//        给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，
//        其中 needs[i] 是需要购买第 i 件物品的数量。
//        还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含
//        第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
//        返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，
//        即使那样会降低整体价格。任意大礼包可无限次购买。


import java.util.*;

/**
 * @author wy
 * @date 2021/10/24 9:39
 */
public class ShoppingOffers638 {
    /*
    首先，我们过滤掉不需要计算的大礼包。
    如果大礼包完全没有优惠（大礼包的价格大于等于原价购买大礼包内所有物品的价格），或者大礼包内不包含任何的物品，
    那么购买这些大礼包不可能使整体价格降低。因此，我们可以不考虑这些大礼包，并将它们过滤掉，以提高效率和方便编码。
    因为题目规定了「不能购买超出购物清单指定数量的物品」，所以只要我们购买过滤后的大礼包，都一定可以令整体价格降低。
    然后，我们计算满足购物清单所需花费的最低价格。
    因为 1≤needs≤6 和 0≤needs[i]≤10，所以最多只有 11^6 = 1771561 种不同的购物清单 needs。我们可以将所有可能
    的购物清单作为状态，并考虑这些状态之间相互转移的方法。用 dp[needs] 表示满足购物清单needs 所需花费的最低价格。
    在进行状态转移时，我们考虑在满足购物清单needs 时的最后一次购买；其中，将原价购买购物清单中的所有物品也视作一次购买。
    具体地，有以下两种情况：
    第一种情况是购买大礼包，此时状态转移方程为：
    dp[needs]=min(i∈K){price(i)+dp[needs−needs(i)]}
    其中，K表示所有可以购买的大礼包的下标集合，i表示其中一个大礼包的下标，price(i)表示第i个大礼包的价格，needs(i)
    表示大礼包中包含的物品清单，needs−needs(i)表示购物清单 needs 减去第 i 个大礼包中包含的物品清单后剩余的物品清单。
    第二种情况是不购买任何大礼包，原价购买购物清单中的所有物品，此时dp[needs] 可以直接求出。
    dp[needs] 为这两种情况的最小值。
    因为大礼包中可能包含多个物品，所以并不是所有状态都可以得到。因此，我们使用记忆化搜索而不是完全遍历的方法，
    来计算出满足每个购物清单needs 所需花费的最低价格。
    具体地，在计算满足当前购物清单cur_needs 所需花费的最低价格 min_price 时，我们可以采用如下方法：
       将 min_price 初始化为原价购买购物清单cur_needs 中的所有物品的花费；
       逐个遍历所有可以购买的大礼包，不妨设当前遍历的大礼包为 cur_special，其价格为special_price：
       计算购买大礼包 cur_special 后新的购物清单 nxt_needs，并递归地计算满足购物清单 nxt_needs 所需花费的最低价格nxt_price；
       计算满足当前购物清单cur_needs 所需花费的最低价格cur_price=special_price+nxt_price；
       如果 cur_price<min_price，则将 min_price 更新为 cur_price。
    返回计算满足购物清单 cur_needs 所需花费的最低价格min_price。
     */
    Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();
    public int shoppingOffers(List<Integer> price,List<List<Integer>> special,List<Integer> needs){
        int n = price.size();

        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }

        return dfs(price, special, needs, filterSpecial, n);
    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; ++i) {
                minPrice += curNeeds.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
            }
            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nxtNeeds = new ArrayList<Integer>();
                for (int i = 0; i < n; ++i) {
                    if (curSpecial.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if (nxtNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, special, nxtNeeds, filterSpecial, n) + specialPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }
}
