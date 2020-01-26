console.log("halo");
// var is global
// let is local, for only a scope
// const constant

// shift delete front
// unshift add front
// push add behind
// pop delete behind

//splice 0 delete all
//spice(startfromindex, howmany) delete specified

function click_click(){
    // for(var i=0; i<10; i++){
    //     console.log(i);
    // }
    // console.log(i); //let means variable declare for a scope only, var on the other hand means declare variable for global scope
    
    // var i=1;
    // while(i<=10){
    //     console.log(i)
    //     i++
    // }

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var add = 0;
    //check whether there is @
    for(let i=0; i<username.length; i++){
        if(username[i] == "@"){
            add++;
            break;
        }
    }
    if(add==0){
        alert("SALAH USERNAME/EMAIL")
        return;
    }

    if(password.length == 0){
        alert("harus di isi passwordnya");
        return;
    }

    var num = 0;
    var alp = 0;

    for (let i=0; i<password.length; i++){
        if(password[i] >= '0' && password[i] <= '9'){
            num++;
        }
        if((password[i] >= 'a' && password[i] <= 'z') || (password[i]>='A' && password[i]<='Z')){
            alp++;
        }
        if(alp>0&&num>0){
            break;
        }
    }
    if(alp == '0' || num == 0){ //=== checks if data type same. === value and datatype
        alert("PASSWORD MUST BE ALPHANUMERIC")
        return;
    }
}

function over(){
    // alert("halo")
}

var button = document.getElementById("submitButton");
button.onmouseover = over; //call function from js here