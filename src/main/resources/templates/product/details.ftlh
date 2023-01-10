<#import "../layout/layout.ftlh" as layout/>

<@layout.begin "Product details"/>

    <h2>${product.model} (${product.brand})</h2>

    <div>
        <span>price:</span>${ product.price } $
    </div>
    <div>
        <h3>categories</h3>
        <ul>
            <#list product.categories as cat>
                <li>${cat}</li>
            </#list>
        </ul>
    </div>

    <a href="/product/update/${id}">
        <button class="btn btn-info">update</button>
    </a>
    <a href="/product/delete/${id}">
        <button class="btn btn-danger">delete</button>
    </a>
    <a href="/product/all">
        <button class="btn btn-primary">return to list</button>
    </a>

<@layout.end/>