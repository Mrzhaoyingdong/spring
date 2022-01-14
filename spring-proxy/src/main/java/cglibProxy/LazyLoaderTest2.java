package cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;

/**
 *  使用 lazyLoader实现延迟加载
 *  @Description: {@link LazyLoader}
 *  @author: zhao_yd
 *  @Date: 2021/1/24 11:10 上午
 *
 */

public class LazyLoaderTest2 {

    public static class BlogModule{

        private String title;

        private BlogContentModel blogContentModel;

        public BlogModule(){
            this.title = "spring aop详解!";
            this.blogContentModel = getBlogContentModel();
        }


        public BlogContentModel getBlogContentModel(){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(BlogContentModel.class);
            LazyLoader lazyLoader = new LazyLoader() {
                @Override
                public Object loadObject() throws Exception {
                    System.out.println("从数据库开始获取详细信息.....");
                    BlogContentModel blogContentModel = new BlogContentModel();
                    blogContentModel.setContent("这是微博的详细信息，请查收。");
                    return blogContentModel;
                }
            };
            enhancer.setCallback(lazyLoader);
            return (BlogContentModel)enhancer.create();
        }


        public static class BlogContentModel{

            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }

    public static void main(String[] args) {
        BlogModule blogModule = new BlogModule();
        System.out.println(blogModule.title);
        System.out.println("详情");
        System.out.println(blogModule.blogContentModel.getContent());
    }
}
