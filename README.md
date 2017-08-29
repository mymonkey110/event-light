# event-light

> 领域事件的实践DEMO

#### 更新日志：

2017-08-29

补充了最新的领域事件实现方式，以下单为例

#### DEMO简介

  本DEMO以常用的用户注册\登录\登出为例,介绍领域事件的应用以及几种实现方式的不同.

#### 运行方法

    > git clone https://github.com/mymonkey110/event-light.git
    > cd event-light
    > mvn spring-boot:run

#### 工程结构

  * 核心层   包含用户和领域事件
  * 基础设施层  包括Email发送的示例
  * 应用层 监听用户注册\登出事件,统计登录次数
  * WEB层 用户UI层

#### 详细分析

  * 用户注册(异步发送领域事件)

    在浏览器访问:<http://localhost:8080/user/register.do?name=michael&age=10> 模拟用户注册

    观察日志发现,注册统计和发送EMAIL的执行与处理request的执行线程不同,说明异步发送是成功的.

  * 用户登录(同步发送领域事件)

    在浏览器访问:<http://localhost:8080/user/login.do?name=michael> 模拟用户登录

    观察日志发现,登录统计的执行和request的处理在同一个线程中,说明同步发送是成功的.

  * 用户登出(Spring同步发送领域事件)

    与上面两种事件处理机制不同,用户登出事件利用了Spring自带的事件机制.

    在浏览器访问:<http://localhost:8080/user/logout.do?name=michael> 模拟用户登出

    观察日志发现,用户登出监听器和request的处理在同一个线程中,说明Spring自带的是同步的.

  设计初衷见我的博客:
  [实现领域事件](http://michael-j.net/2016/01/19/实现领域事件/)
  [再谈领域事件](http://michael-j.net/2017/08/13/再谈领域事件/)
  

#### MIT LICENSE



