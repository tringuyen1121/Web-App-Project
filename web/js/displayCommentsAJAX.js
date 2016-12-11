/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function myFunction(arr) {
    var output = "";
    
    for (var i = 0; i < arr.length; i++) {
        output += '<li class="comment">' +
                                        '<a href="User?search='+arr[i].Username+'">'+arr[i].Username+'</a>' +
                                        '<p class="hyphenate">'+arr[i].Comment+'</p>' +
                                    '</li>';
    }
    document.getElementById('comment-list').innerHTML = output;
}

var xhr = new XMLHttpRequest();

var showComments = function () {
    if (this.readyState == 4 && this.status == 200) {
        var myArr = JSON.parse(this.responseText);
        console.log(myArr);
        myFunction(myArr.comments);
    }

};

xhr.open("GET", "GetCommentsAsJSON?image="+imageID, true);
xhr.onreadystatechange = showComments;
xhr.send();

