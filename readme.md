## BitLog：一个试手的个人博客项目
### 拟采用技术栈
> 开发语言：*Java/JavaScript*
> 
> 开发框架：*SpringBoot/Vue.js*
> 
> UI组件框架:*Vuetify*
> 
> 数据库：*MySQL*
> 
> 持久层：*MyBatis*
> 
> 连接池：*HikariPool*
> 
> 日志系统：*Logback* 

### 核心功能：
博客发帖(文字、图片、视频、~~B站嵌入链接~~)

帖子下方评论区(审核功能怎么做？)

### 帖子功能：
根据设置的大类分类查看：暂拟热门、Java、Vue、数据库、Redis、中间件、SpringBoot、BitLog开发

帖子查看排序：热度(默认)、最多浏览、最多点赞、最新发布、最早发布
> Double hotpoint 热度值

### 热度值影响算法
> 热度影响因素主要有：__点赞数__、__浏览数__、__评论数__、__发布时间__
> 
> 根据Hacker News社区的热度算法。引入连续时间衰减系数，排名策略同时考虑用户点赞数和时间因素
> 
> Score=((P−1)^α*(V-1)^β*C^∑)/((T+2)^G)
> 
> 其中P代表点赞数，-1是为了消除自己给自己点赞的影响。α（0<α<1）调节点赞数的影响力
>
> V代表浏览数，-1是为了抵消发帖后自己查看的影响。β（0<β<1）调节浏览数的影响力
> 
> C代表评论数，∑（0<∑<1）调节评论数的影响力
> 
>T代表表示距离发帖的时间（单位为小时）
> 
> G表示“重力因子”（gravityth power，G>1），即将帖子排名往下拉的力量

### MySQL建表
> ### Post表(博客贴)
> bigint id 帖子ID(主键)
>
> varchar title 帖子标题
>
> varchar type 帖子分类
>
> bigint creater 创建者ID
>
> datetime createtime 创建日期
>
> datetime updatetime 更新日期
>
> int likes 点赞数
>
> int views 浏览数
> 




