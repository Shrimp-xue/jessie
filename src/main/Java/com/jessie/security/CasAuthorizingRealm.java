package com.jessie.security;

import org.apache.shiro.cas.CasRealm;


/**
 * 系统安全认证单点登录实现类
 */
public class CasAuthorizingRealm extends CasRealm {

//    private SystemService systemService;
//
//    public CasAuthorizingRealm() {
//        super();
//    }
//
//    /**
//     * 认证
//     */
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//
//        CasToken casToken = (CasToken) token;
//        if (token == null)
//            return null;
//        String ticket = (String) casToken.getCredentials();
//        if (!StringUtils.hasText(ticket))
//            return null;
//        TicketValidator ticketValidator = ensureTicketValidator();
//        try {
//            Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
//            // casPrincipal 认证后的用户信息
//            AttributePrincipal casPrincipal = casAssertion.getPrincipal();
//            String userId = casPrincipal.getName();
//
//            // 获取用户
//            User user = getSystemService().getUserByLoginName(userId);
//
//            Map<String, Object> attributes = casPrincipal.getAttributes();
//            casToken.setUserId(userId);
//            String rememberMeAttributeName = getRememberMeAttributeName();
//            String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
//            boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
//            if (isRemembered)
//                casToken.setRememberMe(true);
//            // 这里可以拿到Cas的登录账号信息,加载到对应权限体系信息放到缓存中...
//            return new SimpleAuthenticationInfo(new Principal(user, false), ticket, getName());
//        } catch (TicketValidationException e) {
//            throw new CasAuthenticationException(
//                    (new StringBuilder()).append("Unable to validate ticket [").append(ticket).append("]").toString(),
//                    e);
//        }
//    }
//
//    /**
//     * 授权
//     */
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        Principal principal = (Principal) getAvailablePrincipal(principals);
//
//        User user = getSystemService().getUserByLoginName(principal.getLoginName());
//        if (user != null) {
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            List<Menu> list = UserUtils.getMenuList();
//            for (Menu menu : list) {
//                if (org.apache.commons.lang3.StringUtils.isNotBlank(menu.getPermission())) {
//                    // 添加基于Permission的权限信息
//                    for (String permission : org.apache.commons.lang3.StringUtils.split(menu.getPermission(), ",")) {
//                        info.addStringPermission(permission);
//                    }
//                }
//            }
//            // 添加用户权限
//            info.addStringPermission("user");
//            // 添加用户角色信息
//            for (Role role : user.getRoleList()) {
//                info.addRole(role.getEnname());
//            }
//            // 更新登录IP和时间
//            getSystemService().updateUserLoginInfo(user);
//            // 记录登录日志
//            LogUtils.saveLog(Servlets.getRequest(), "系统登录");
//            return info;
//        } else {
//            return null;
//        }
//
//    }
//
//    protected List<String> split(String s) {
//        List<String> list = new ArrayList<String>();
//        String elements[] = StringUtils.split(s, ',');
//        if (elements != null && elements.length > 0) {
//            String arr$[] = elements;
//            int len$ = arr$.length;
//            for (int i$ = 0; i$ < len$; i$++) {
//                String element = arr$[i$];
//                if (StringUtils.hasText(element))
//                    list.add(element.trim());
//            }
//
//        }
//        return list;
//    }
//
//    protected void addRoles(SimpleAuthorizationInfo simpleAuthorizationInfo, List<String> roles) {
//        String role;
//        for (Iterator<String> i$ = roles.iterator(); i$.hasNext(); simpleAuthorizationInfo.addRole(role))
//            role = (String) i$.next();
//
//    }
//
//    protected void addPermissions(SimpleAuthorizationInfo simpleAuthorizationInfo, List<String> permissions) {
//        String permission;
//        for (Iterator<String> i$ = permissions.iterator(); i$.hasNext(); simpleAuthorizationInfo
//                .addStringPermission(permission))
//            permission = (String) i$.next();
//
//    }
//
//    public SystemService getSystemService() {
//        if (systemService == null) {
//            systemService = SpringContextHolder.getBean(SystemService.class);
//        }
//        return systemService;
//    }

}