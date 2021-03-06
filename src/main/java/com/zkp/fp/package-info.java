/**
 * 从n个资金池中支取若干资金f，资金支取后资金池差额比较接近，其实是对标准差或方差的计算
 * 标准差或方差越小越均衡，所有数据的均衡程度跟支出后的平均值有关系。
 * 说明：资金计算采用BigDecimal，确保计算的准确性
 * 思路简要描述：
 * 1、检测参数输入，参数是否合法，支出是否超过最大透支额度
 * 2、支出超过或等于资金池集总资金，直接按支出与总资金的差值平均值计算
 * 3、支出小于资金池集总资金，先进行排序，依次进行分配
 * @date: 2019/2/27
 */
package com.zkp.fp;