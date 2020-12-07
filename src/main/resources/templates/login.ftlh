<#import "parts/common.ftlh" as p>
<#import "parts/form.ftlh" as f>

<@p.page>
<div>Login</div>
<@f.login "/login" />
<a href="/registration">Add new user</a>
</@p.page>