package com.usping.kdsn.util.interceptor;

import com.usping.kdsn.bean.User;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(type=Executor.class, method="insert", args={MappedStatement.class, Object.class})})
public class EncryptInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        String methodName = invocation.getMethod().getName();
        Object parameter = invocation.getArgs()[1];
        BoundSql sql = statement.getBoundSql(parameter);

        if(parameter instanceof User){
            System.out.println(parameter.toString());
        }
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
