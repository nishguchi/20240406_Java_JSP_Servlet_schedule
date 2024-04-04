//console.log("testです");


var pass = document.getElementById("PASS").value;
var isRight = true;

alert(pass.length);

function Form() {


  if(pass.length >=25) {
      document.getElementById("message").innerHTML = "※半角英数字25文字以下で入力してください";
      isRight = false;
  }

return isRight;
}



