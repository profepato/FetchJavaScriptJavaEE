var clientName = document.getElementById("clientName");
var tableBody = document.getElementById("tableBody");

clientName.addEventListener("keyup", function(event){
    //if(event.key == "Enter"){
        // hacer la peticion GET hacia el servlet
        var url = "http://localhost:8080/FetchJavaScriptJavaEE_war_exploded/clients.do?clientName="+clientName.value;

        var data = {
            method: 'GET'
        };

        fetch(url, data)
            .then(function(response) {
                return response.json();
            })
            .then(function(clients) {
                console.log(clients);
                var rows = "";

                for(i in clients){
                    rows +=
                        "<tr>" +
                            "<td>"+clients[i].name+"</td>" +
                            "<td>"+clients[i].age+"</td>" +
                        "</tr>";
                }

                tableBody.innerHTML = rows;
            });
    //}
});