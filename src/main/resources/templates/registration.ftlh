<#import "parts/common.ftlh" as p>
<#import "parts/form.ftlh" as f>
<@p.page>
<div>Registration</div>
${message!""}
<@f.login "/registration" />
</@p.page>