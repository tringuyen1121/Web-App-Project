/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xhr = new XMLHttpRequest();
var username = document.getElementById("user-username");

var checkAvaibility = function () {
    if (xhr.readyState == 4 && xhr.status == 200) {
        if (username.value.length > 6) {
            if (xhr.responseText == "available") {
                username.style.border = '2px solid rgba(141, 247, 89, 1)';
                username.style.boxShadow = '0 0 5px rgba(183, 248, 151, 1)';
            }
        } else {
            username.style.border = '2px solid rgba(245, 96, 66, 1)';
            username.style.boxShadow = '0 0 5px rgba(255, 184, 179, 1)';
        }
    }
};

xhr.open("POST", "checkUsername", true);
username.addEventListener("change", function () {
    xhr.onreadystatechange = checkAvaibility;
});
xhr.send("username=" + username.value); 