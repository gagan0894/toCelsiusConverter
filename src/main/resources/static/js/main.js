function convert() {
       console.log("on click of a button");
       var input=document.getElementById("temperatureInput").value;
       var unit=document.getElementById("toUnit").value;
       var data={
           input:input,
           toUnit: "Celsius",
           fromUnit:unit

       };
    if (input && input != "") {

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/convert",
            data: JSON.stringify(data),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (parsed_data) {

                console.log("call success...");
                console.log("result: " + parsed_data.result);
                //var parsed_data = JSON.parse(data);
                // document.getElementById("result").value=parsed_data.result;
                $("#result").html((Math.round(parsed_data.result * 100) / 100).toFixed(2));
            },
            error: function (e) {
                alert("call failed...");


            }
        });
    }
    else
    {
        $("#result").html("0");
    }
}
