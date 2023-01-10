<#import "/spring.ftl" as spring/>
<#import "../layout/layout.ftlh" as layout/>

<@layout.begin "insert product"/>
    <h1>Product - INSERT FORM</h1>

    <form action="/product/insert" method="post">
        <div class="mb-3">
            <label for="in-brand" class="form-label">brand</label>
            <@spring.bind path="form.brand"/>
            <input type="text" name="${spring.status.expression}" class="form-control" id="in-brand">
        </div>
        <div class="mb-3">
            <label for="in-model" class="form-label">model</label>
            <@spring.bind path="form.model"/>
            <input type="text" name="${spring.status.expression}" class="form-control" id="in-model">
        </div>
        <div class="mb-3">
            <label for="in-price" class="form-label">price</label>
            <@spring.bind path="form.price"/>
            <input type="number" name="${spring.status.expression}" class="form-control" id="in-price">
        </div>

        <div class="mb-3">
            <label for="in-price" class="form-label">price</label>
            <@spring.bind path="form.categories"/>
            <select class="form-select" name="${spring.status.expression}" multiple aria-label="multiple select example">
                <#list categories as category>
                    <option value="${category.id}">${category.name}</option>
                </#list>
            </select>
        </div>

        <button class="btn btn-success" type="submit">envoyer</button>
        <button class="btn btn-danger" type="reset">annuler</button>
    </form>
<@layout.end/>