## 记录BitLog开发过程中遇到的逆天Bug和失误
### (虽然绝大多数错误是我自己造成的)
> ### 异常报错org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible
> <font color=Green>问题状况：已解决</font>
> 
> __问题原因：__
> 
> __application.properties__ 中spring.datasource.url设置有问题

> ### md插件默认值使用从后端读取的数据时，刷新会导致除md插件外其他全部组件失效，且无法正常返回
> <font color=Green>问题状况：已解决</font>
>
> __问题原因：__
>
> fetchArticle 中将 article 设置为响应式对象，但在页面加载时，它的值是 undefined，
> 所以如果在模板中尝试访问 article.title，会因为 article 初始为空导致报错
> 
> __解决办法：__
> 给article一个默认空值，既不报错也正常加载了...
> 
> **const article = ref({})**
