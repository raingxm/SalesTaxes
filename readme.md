SalesTaxes
==========

ThoughtWorks 小作业  张旭(raingxm)   13484551469
---------------------

### 测试
采用Junit进行单元测试，完成小作业过程中尽量采用了TDD开发模式。

### 设计
Product类，只要用来通过输入的一行产品信息，产生一个Product对象。Product类提供了静态方法用来添加商品种类的方法，可以加入属于食物的产品、属于药物的产品和属于书的产品。

TaxRate类，用来计算产品应交的税，并进行四舍五入以及进位规则(0.05).

ShopSeller类，通过输入的数据来产生Product的集合，并计算所有产品的总价格和总共交的税。可以判断输入的信息格式是否满足要求，不满足要求会抛出异常。

Exporter接口，用来进行输出操作

ConsoleExporter实现了Exporter接口，将结果输出到控制台

FileExporter实现了Exporter接口，将结果输出到文件

### 参考
输出到文件或者控制台这部分,参考了上一次FizzBuzzWhizz作业网上一个人的[实现](https://github.com/zacker330/FizzBuzz)。
TDD开发模式，参考了James Shore 网上的 [let's play tdd 课程](https://www.youtube.com/channel/UCMDg-RTfD384BAUw_Eq2hIg)

### 致谢
感谢实验室的刘慧敏、周佳薇以及长安大学的高中同学郑西彬同学，能够和很多人一起完成作业，讨论思路改进代码，这个过程很让人享受。

感谢ThoughtWorks的杨朕，没有他或许我不可能接触到TDD。

感谢其他ThoughtWorks员工和HR们，整个招聘过程中为准备进入职场的同学们答疑解惑并且还发给我小礼物。
