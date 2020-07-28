
function background(){
var weather = data.weather[0].description;


switch(weather) {
      case 'broken clouds':
        $('body').css("background-image", "url(/images/broken-clouds.jpg)");
        break;
      case 'clear sky':
        $('body').css("background-image", "url(/images/clear-sky.jpg)");
        break;
      case 'few clouds':
        $('body').css("background-image", "url(/images/few-clouds.jpg)");
        break;
      case 'mist':
        $('body').css("background-image", "url(/images/mist.jpg)");
        break;
      case 'rain':
        $('scattered clouds').css("background-image", "url(/images/rain.jpg)");
        break;
      case 'shower rain':
       $('body').css("background-image", "url(/images/shower-rain.jpg);
        break;
      case 'snow':
       $('body').css("background-image", "url(/images/snow.jpg);
        break;
      case 'thunderstorm':
       $('body').css("background-image", "url(/images/thunderstorm.jpg);
        break;
      default:
        $('body').css("background-image", "url(/images/clear-sky.jpg)");
        break;
    }

    document.getElementById("row").innerHTML = weather;
 }