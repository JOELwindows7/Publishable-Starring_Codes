// main javascript main.js

//console.log("test");

$(document).ready(function(){
    //using $ means refer to jquery library
    //$('#p1').hide(1000).show(1000).hide(1000);
    //$('#p1').hide('slow').show('fast')
    //$('#p1').slideUp(1000).slideDown(1000);
    //$('#p1').slideUp(1000)
    //$('#p1').fadeOut(1000);
    // milisecond

    //event
    // $('#p1').click(function(){
    //     $('#p2').slideUp(1000);
    // });
    
    // $('#p1').click(function(){
    //     $('#p2').toggle(1000);
    // });

    //var check=0;
    // $('#p1').click(function(){
    //     if(check==0){
    //         $('#p2').slideUp();
    //         check=1;
    //     } else {
    //         $('#p2').slideDown();
    //         check=0;
    //     }
    // });
    // $('#p1').click(function(){
    //     if(check==0){
    //         $('#p2').css({
    //             'background': 'red'
    //         });
    //         check=1;
    //     } else {
    //         $('#p2').css({
    //             'background': 'blue',
    //             'font-size' : '30px'
    //         });
    //         check=0;
    //     }
    // });

    // $('p[id=p1]').css({ //select all p. [] attribute
    //     'font-size':'30px'
    // })
    var i=1;
    var length = $('.slide').length;
    function slidinger(){ 
        $('.slides').animate({'margin-left':'-=50vh'},300, function(){
            i++;
            if(i==length){
                $('.slides').css('margin-left',0)
                i=1;
            }
        })
        // -= decrement
        // {} css styler. space sensitive!!!
    }
    setInterval(slidinger,2000) //give () after that slidinger triggers it immediately
})