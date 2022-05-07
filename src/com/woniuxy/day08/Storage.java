package com.woniuxy.day08; /**
 * 实现以下功能：
 * 1.声明一个产品(Product)类，声明其属性（编号：no,名称：name,库存：stock)|I
 * 2.声明一个仓库(Storage)类，属性为大小为10的产品数组
 *   在Storage:类中，有如下方法：
 *   入库：参数是产品，将其存入产品数组中，如果其中无该产品且数组有空间存储，则加到数组中，
 *   存在该产品，则更新其库存，重复规则：no唯一和name唯一
 *   出库：参数是产品编号和数量，先查询是否存在该产品，
 *   如果存在：
 *   则判断出库数量是否小于或等于其库存，符合条件则减少其库存，否则不作操作，仅提示
 *   如果不存在该产品，则不做操作，仅提示
 *   盘点：输出仓库中所有产品的信息
 * 3.编写测试类进行测试
 *
 *
 *
 */
//package com.woniuxy.day08;
//
//public class Storage {
//      Products[] product = new Products[10];
//      int num = 0;
//
//      void inStorage(Products p) {
//            //判断是否是第一个入库产品
//            if(num == 0){
//                  product[num] = p;
//                  product[num].no = p.no;
//                  product[num].name = p.name;
//                  product[num].stock = p.stock;
//            } else if (num < product.length){
//                  for(int i = 0; i < product.length; i++){
//                        if(p.no == product[i].no){
//                              product[i].stock++;
//                        } else
//                        num ++;
//
//                  }
//
//
//            } else{
//
//            }
//
//
//      }
//
//
//
//}
