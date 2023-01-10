<#import "../layout/layout.ftlh" as layout/>

<@layout.begin "all products"/>

    <h1>Mes produits</h1>

    <div>
        <a href="/product/insert">
            <button class="btn btn-info">add more</button>
        </a>
    </div>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">model</th>
                <th scope="col">brand</th>
                <th scope="col">price</th>
                <th scope="col">action</th>
            </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td>${product.brand}</td>
                    <td>${product.model}</td>
                    <td>${product.price}$</td>
                    <td>
                        <a href="/product/details/${product.id}">
                            <button class="btn btn-secondary">details</button>
                        </a>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>

<@layout.end/>