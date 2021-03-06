# GradlePlugins_400

#### 介绍
com.android.tools.build:gradle:4.0.0

distributionUrl=https\://services.gradle.org/distributions/gradle-6.1.1-bin.zip

参考对应关系：[https://developer.android.google.cn/studio/releases/gradle-plugin.html#updating-gradle](https://developer.android.google.cn/studio/releases/gradle-plugin.html#updating-gradle)

#### 软件架构
Gradle 插件开发demo


#### 安装教程

1.  注释掉 project/build.gradle 中 publish 的 classpath
2.  注释掉 project/build.gradle 中 aop 的 classpath

3.  setting.gradle 中 只留下 app 和 publish
4.  运行 gradle publish

5.  setting.gradle 中 放开 aop-plugin 和 aop-annotation
6.  运行 gradle publish

7.  setting.gradle 中 放开 aop-runtime
8.  运行 gradle publish

#### 使用说明

#### publish 插件

1.   project/build.gradle  中添加 publish 的 classpath
2.   library/build.gradle  中使用 publish 插件，并配置 publishConfig

#### aop 插件

1.  project/build.gradle  中添加 aop 的 classpath
2.  runtime/build.gradle  中使用 aop 插件

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
