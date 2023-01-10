<#import "/spring.ftl" as spring/>
<#import "../layout/layout.ftlh" as layout/>

<@layout.begin "insert product"/>
    <h1>Product - INSERT FORM</h1>

    <form action="/product/update/${product_data.id}" method="post">
        <div class="mb-3">
            <label for="in-brand" class="form-label">brand</label>
            <@spring.bind path="form.brand"/>
            <input type="text" name="${spring.status.expression}" value="${product_data.brand}" class="form-control" id="in-brand">
            <@spring.showErrors "</br>"/>
        </div>
        <div class="mb-3">
            <label for="in-model" class="form-label">model</label>
            <@spring.bind path="form.model"/>
            <input type="text" name="${spring.status.expression}" value="${product_data.model}" class="form-control" id="in-model">
            <@spring.showErrors "</br>"/>
        </div>
        <div class="mb-3">
            <label for="in-price" class="form-label">price</label>
            <@spring.bind path="form.price"/>
            <input type="number" name="${spring.status.expression}" value="${product_data.price}" class="form-control" id="in-price">
            <@spring.showErrors "</br>"/>
        </div>

        <button class="btn btn-success" type="submit">envoyer</button>
        <button class="btn btn-danger" type="reset">annuler</button>
    </form>
<@layout.end/>