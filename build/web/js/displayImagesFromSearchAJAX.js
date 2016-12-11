/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function myFunction(arr) {
    var output = "";

    for (var i = 0; i < arr.length; i++) {
        var tagArray = arr[i].Tags.split(',');
        output += '<li class="thumbnail">' +
                '<figure>' +
                '<div class="image-container">' +
                '<a href="Image?image=' + arr[i].Image_ID + '"><img src="' + arr[i].Path + '" alt="' + arr[i].Image_name + '"/></a>' +
                '</div>' +
                '<figcaption>' +
                '<div class="image-info">' +
                '<div class="image-name"><a href="Image?image=' + arr[i].Image_ID + '">' + arr[i].Image_name + '</a></div>' +
                '<div class="image-by-wrap">' +
                '<br>' +
                '<span class="by">by </span>' +
                '<a class="owner-link" href="User?search=' + arr[i].Username + '">' + arr[i].Username + '</a>' +
                '</div>' +
                '<div class="image-tags">' +
                '<hr>';
        if (tagArray.length == 1) {
            output += '<a class="single-tag" href="ImagessSearch?search=tag:' + arr[i].Tags + '" title="' + arr[i].Tags + '">' + arr[i].Tags + '</a>';
        } else {
            for (var k = 0; k < tagArray.length; k++) {
                output += '<a class="single-tag" href="ImagesSearch?search=tag:' + tagArray[k] + '" title="' + tagArray[k] + '">' + tagArray[k] + '</a>';
            }
        }
        output += '</div>' +
                '</div>' +
                '<div class="image-stats">' +
                '</div>' +
                '</figcaption>' +
                '</figure>' +
                '</li>';
    }
    document.getElementById('image-grid').innerHTML = output;
}

var xhr = new XMLHttpRequest();

var showImages = function () {
    if (this.readyState == 4 && this.status == 200) {
        var myArr = JSON.parse(JSONArr);
        myFunction(myArr.images);
    }
};

xhr.open("GET", "", true);
xhr.onreadystatechange = showImages;
xhr.send();
