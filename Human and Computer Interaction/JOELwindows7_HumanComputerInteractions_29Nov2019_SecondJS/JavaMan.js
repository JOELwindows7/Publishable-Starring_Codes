var a = 0;

(function(){
    //Function anonymous
    let name = 'lie';

    // let func = function(){
    //     console.log(name);
    // }
    let func = () => {
        console.log(name)
    }


    document.getElementById('paragraph-1').onclick=func;
    // minify js to make it faster to load
})();