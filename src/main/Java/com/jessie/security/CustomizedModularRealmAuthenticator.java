package com.jessie.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.realm.Realm;

import java.util.Collection;

/**
 * <p>Title: 自定义Authenticator</p>
 * <p>Description:分别定义处理不同登录方式验证的Realm</p>
 * <p>Date: 2017-7-6</p>
 *
 * @version 1.0
 */
public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator {
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 获取所有Realm
        Collection<Realm> realms = getRealms();
        Realm realm = null;
        // 判断当前token是castoken还是UsernamePasswordToken
        // 强转对应类型token
        // 根据token类型获得对应的Realm
        if (authenticationToken instanceof CasToken) {
            authenticationToken = (CasToken) authenticationToken;
            realm = getRealm(realms, authenticationToken);
        }
        if (authenticationToken instanceof UsernamePasswordToken) {
            authenticationToken = (UsernamePasswordToken) authenticationToken;
            realm = getRealm(realms, authenticationToken);
        }
        // 执行响应Realm
        return doSingleRealmAuthentication(realm, authenticationToken);
    }

    // 判断当前token对应的Realm
    public Realm getRealm(Collection<Realm> realms, AuthenticationToken token) {
        for (Realm realm : realms) {
            if (realm.supports(token)) {
                return realm;
            }
        }
        return null;
    }
}