package com.eqx.demowork.hystrix.start001;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @ClassName CommandHelloWord
 * @Description hello hystrix
 * @Author duanhuazhen
 * @Date 17:53 2019-04-13
 * @Version 1.0
 **/
public class CommandHelloWord extends HystrixCommand<String> {

    private final String name;

    private CommandHelloWord(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        int a = 1 / 0;
        return "Tom";
    }

    @Override
    protected String getFallback() {
        return name + "fallbackc-Jack";
    }

    public static void main(String[] args) throws Exception {
        CommandHelloWord commandHelloWord = new CommandHelloWord("hello ");
        String execute = commandHelloWord.execute();
        System.out.println("The result is ----> " + execute);
    }
}
