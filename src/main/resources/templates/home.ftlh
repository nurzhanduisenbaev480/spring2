<#import "parts/common.ftlh" as p>
<#import "parts/form.ftlh" as f>
<@p.page>
<div class="logout">
    <@f.logout />
</div>
<div>Hello moto</div>
<div class="addMessage">
    <form action="" method="post">
        <label for="text"></label>
        <input class="form-control" type="text" name="text" id="text" placeholder="Enter the text">
        <label for="tag"></label>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input class="form-control" type="text" name="tag" id="tag" placeholder="Enter the tag">
        <button type="submit" class="btn btn-warning">Add Message</button>
    </form>
</div>
<h3>List of Messages</h3>
<form action="/home" method="get">
    <label for="filter"></label>
    <input type="text" name="filter" id="filter" value="${filter!""}">
    <button type="submit" class="btn btn-warning">Find</button>
</form>
<#list messages as message>
<div class="card">
    <b>${message.id}</b>
    <p>${message.text}</p>
    <i>${message.tag}</i>
    <strong>${(message.author.username)!"none"}</strong>
</div>
    <#else>
    No Messages
</#list>
</@p.page>