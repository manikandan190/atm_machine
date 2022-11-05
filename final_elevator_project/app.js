const numOfFloors =25;
let leftLiftDirection = "";
let rightLiftDirection = "";
let threeLiftDirection = "";
let fourLiftDirection = "";
const duration=20;




let leftLiftTotalArrayUp = [];
let leftLiftFrontDown = [];
let leftLiftBackDown = [];
let leftLiftFrontUp = [];
let leftLiftBackUp = [];
let leftLiftTotalArrayDown = [];

let rightLiftTotalArrayUp = [];
let rightLiftFrontDown = [];
let rightLiftBackDown = [];
let rightLiftFrontUp = [];
let rightLiftBackUp = [];
let rightLiftTotalArrayDown = [];

let threeLiftTotalArrayUp = [];
let threeLiftFrontDown = [];
let threeLiftBackDown = [];
let threeLiftFrontUp = [];
let threeLiftBackUp = [];
let threeLiftTotalArrayDown = [];

let fourLiftTotalArrayUp = [];
let fourLiftFrontDown = [];
let fourLiftBackDown = [];
let fourLiftFrontUp = [];
let fourLiftBackUp = [];
let fourLiftTotalArrayDown = [];


let leftLiftPos = 0;
let rightLiftPos = 0;
let threeLiftPos=0;
let fourLiftPos=0;

let leftLiftControls = 0;
let rightLiftControls = 0;
let threeLiftControls=0;
let fourLiftControls=0;








let currentPos;

let leftLiftArray = []
let rightLiftArray = []
let threeLiftArray = []
let fourLiftArray = []

let leftLiftTotalArray=[0];
let rightLiftTotalArray=[0];
let threeLiftTotalArray=[0];
let fourLiftTotalArray=[0];


setInterval(function () {
  
  var elementLift1=document.getElementById("lift1")
  var position1=elementLift1.getBoundingClientRect();
  
  
  leftLiftPos=Math.round(Math.abs((position1.top-100*numOfFloors-194.72918701171875)/100));
  if(leftLiftTotalArray.length!==0)
  {
    if(leftLiftTotalArray[0]-leftLiftPos>=0)
    {
      leftLiftDirection="up"
    }
    else {
      leftLiftDirection="down"
    }
  }
  console.log(leftLiftPos+" "+leftLiftDirection)









  var elementLift2=document.getElementById("lift2")
  var position2=elementLift2.getBoundingClientRect();
  rightLiftPos=Math.round(Math.abs((position2.top-100*numOfFloors-194.72918701171875)/100));
  if(rightLiftTotalArray.length!==0)
  {
    if(rightLiftTotalArray[0]-leftLiftPos>=0)
    {
      rightLiftDirection="up"
    }
    else {
      rightLiftDirection="down"
    }
  }
  console.log(rightLiftPos+" "+rightLiftDirection)

  
  // console.log(rightLiftPos)
  var elementLift3=document.getElementById("lift3")
  var position3=elementLift3.getBoundingClientRect();
  threeLiftPos=Math.round(Math.abs((position3.top-100*numOfFloors-194.72918701171875)/100));
  if(threeLiftTotalArray.length!==0)
  {
    if(threeLiftTotalArray[0]-leftLiftPos>=0)
    {
      threeLiftDirection="up"
    }
    else {
      threeLiftDirection="down"
    }
  }
  console.log(threeLiftPos+" "+threeLiftDirection)
  // console.log(threeLiftPos)
  var elementLift4=document.getElementById("lift4")
  var position4=elementLift4.getBoundingClientRect();
  fourLiftPos=Math.round(Math.abs((position4.top-100*numOfFloors-194.72918701171875)/100));
  if(fourLiftTotalArray.length!==0)
  {
    if(fourLiftTotalArray[0]-leftLiftPos>=0)
    {
      fourLiftDirection="up"
    }
    else {
      fourLiftDirection="down"
    }
  }
  console.log(fourLiftPos+" "+fourLiftDirection)
  // console.log(fourLiftPos)
 
 
}, 1000) 
const building = document.querySelector('.building');
const functionality = document.querySelector('.functionality');
const controlPanel = document.querySelector('.control-panel');

window.addEventListener('DOMContentLoaded', () => {
  building.innerHTML = displayBuilding(numOfFloors);
  controlPanel.innerHTML = displayCallButtons();
  display_Lift_Floor_Buttons(0, 'left');
  display_Lift_Floor_Buttons(0, 'right');
  display_Lift_Floor_Buttons(0, 'three');
  display_Lift_Floor_Buttons(0, 'four');


});


const displayBuilding = (numOfFloors) => {
  let floorHTML = '';
  for (let index = numOfFloors; index >= 0; index--) {
    floorHTML += `
      <div class="floor">
        <div class="entry entry--left">
          <div class="door door--left">
          <img src="/img/off.jpeg" width="50px" height="50px"/></div>
        </div>
        <div class="floor-num-cont">
          <div class="floor-num">${index}</div>
        </div>
        <div class="entry entry--right">
          <div class="door door--left">
          <img src="/img/off.jpeg" width="50px" height="50px"/></div>
        </div>
        <div class="floor-num-cont">
        <div class="floor-num">${index}</div>
      </div>
      <div class="entry entry--three">
      <div class="door door--left">
      <img src="/img/off.jpeg" width="50px" height="50px"/></div>
    </div>
    <div class="entry entry--four">
    <div class="door door--left">
    <img src="/img/off.jpeg" width="50px" height="50px"/></div>
  </div>
      </div>
    `;
  }
  return `
    <div class="building-text-cont">
      <h2>Building</h2>
      <div class="side-cont side-cont--building">
      </div>
    </div>
    <div class="lift lift--left" id="lift1">
      <div class="door door--left">
      <img src="/img/on.jpeg" width="50px" height="50px"/></div>
    </div>
    <div class="lift lift--right" id="lift2">
      <div class="door door--right">
      <img src="/img/on.jpeg" width="50px" height="50px"/>
      </div>
      </div>

      <div class="lift lift--three" id="lift3">
      <div class="door door--three">
      <img src="/img/on.jpeg" width="50px" height="50px"/>
      </div>
      </div>
      <div class="lift lift--four" id="lift4">
      <div class="door door--four">
      <img src="/img/on.jpeg" width="50px" height="50px"/>
      </div>
      </div>

    </div>
    ${floorHTML}

  `;
};






const displayCallButtons = () => {

  let displayAllButtonsHTML = '';
  for (let index = numOfFloors; index >= 0; index--) {
    displayAllButtonsHTML += `
      <div class="floor__buttons">
        <div class="call-button-cont">
      
          <button class="call-button call-button--${index}-up" id="up">↑</button>
          <button class="call-button call-button--${index}-down" id="down">↓</button>
          
        </div>
        <div class="lift-buttons lift-buttons--left lift-buttons--${index}--left"></div>
        <div class="lift-buttons lift-buttons--right lift-buttons--${index}--right"></div>
        <div class="lift-buttons lift-buttons--three lift-buttons--${index}--three"></div>
        <div class="lift-buttons lift-buttons--four lift-buttons--${index}--four"></div>
      </div>
    `;
  }
  return `${displayAllButtonsHTML}`
};













let leftControlsTimer;
let rightControlsTimer;
const display_Lift_Floor_Buttons = (floor, side) => {
  let floorButtonsInnerHTML = '';
  let floorButtonsDiv = document.querySelector(`.lift-buttons--${floor}--${side}`);
  for (let index = numOfFloors; index >= 0; index--) {


    floorButtonsInnerHTML += `
    <button class="lift-floor-button--${side}" id="lift-floor-button-${side}--${index}">${index}</button>
    
   
  `;
  }

  floorButtonsDiv.innerHTML = floorButtonsInnerHTML;
};




























let leftOpacFade;
let rightOpacFade;
let threeOpacFade;
let fourOpacFade;
const moveLift = (floor, side) => {

  let lift = document.querySelector(`.lift--${side}`);
 

  if (side === 'left') {
    lift.style.transform = `translateY(${floor * -100}px)`;
    lift.style.opacity = '1';
   

 
    leftOpacFade = setTimeout(() => {
     
       
    
      document.getElementById(`lift-floor-button-left--${floor}`).style.backgroundColor = '#EFEFEF';
    
      if (leftLiftTotalArray.length !== 0) {
        moveLift( leftLiftTotalArray.shift(), 'left')
     
        if (leftLiftFrontDown.includes(leftLiftTotalArray[0])) {
          console.log();
          // console.log(leftLiftFrontDown.shift());
        }
        if (leftLiftFrontUp.includes(leftLiftTotalArray[0])) {
          console.log();
          // console.log(leftLiftFrontUp.shift());
        }
        if (leftLiftBackDown.includes(leftLiftTotalArray[0])) {
          console.log();
          // console.log(leftLiftBackDown.shift());
        }
        if (leftLiftBackUp.includes(leftLiftTotalArray[0])) {
          console.log();
          // console.log(leftLiftBackUp.shift());
        }
        // console.log("leftLiftTotalArray"+leftLiftTotalArray)
        

      }

      if (leftLiftTotalArray.length === 0) {
        leftLiftTotalArrayUp = [];
        leftLiftFrontDown = [];
        leftLiftBackDown = [];
        leftLiftFrontUp = [];
        leftLiftBackUp = [];
        leftLiftTotalArrayDown = [];
        leftLiftDirection=''
      }


    }, 5000);



  } 
  else if(side==="right")
  {

    lift.style.transform = `translateY(${floor * -100}px)`;
    lift.style.opacity = '1';
    rightOpacFade = setTimeout(() => {


      document.getElementById(`lift-floor-button-right--${floor}`).style.backgroundColor = '#EFEFEF';
      if (rightLiftTotalArray.length !== 0) {
        moveLift(rightLiftPos = rightLiftTotalArray.shift(), 'right')

        if (rightLiftFrontDown.includes(rightLiftTotalArray[0])) {
          console.log();
          console.log(rightLiftFrontDown.shift());
        }
        if (rightLiftFrontUp.includes(rightLiftTotalArray[0])) {
          console.log();
          console.log(rightLiftFrontUp.shift());
        }
        if (rightLiftBackDown.includes(rightLiftTotalArray[0])) {
          console.log();
          console.log(rightLiftBackDown.shift());
        }
        if (rightLiftBackUp.includes(rightLiftTotalArray[0])) {
          console.log();
          console.log(rightLiftBackUp.shift());
        }
        console.log("rightLiftTotalArray"+rightLiftTotalArray)

      }
      if (rightLiftTotalArray.length === 0) {
        rightLiftTotalArrayUp = [];
        rightLiftFrontDown = [];
        rightLiftBackDown = [];
        rightLiftFrontUp = [];
        rightLiftBackUp = [];
        rightLiftTotalArrayDown = [];
        rightLiftDirection=''
      }




    }, 5000);

  }
  else if(side==="three"){

    
    lift.style.transform = `translateY(${floor * -100}px)`;
    lift.style.opacity = '1';
    threeOpacFade = setTimeout(() => {


      document.getElementById(`lift-floor-button-three--${floor}`).style.backgroundColor = '#EFEFEF';
      if (threeLiftTotalArray.length !== 0) {
        moveLift(threeLiftPos = threeLiftTotalArray.shift(), 'three')

        if (threeLiftFrontDown.includes(threeLiftTotalArray[0])) {
          console.log();
          console.log(threeLiftFrontDown.shift());
        }
        if (threeLiftFrontUp.includes(threeLiftTotalArray[0])) {
          console.log();
          console.log(threeLiftFrontUp.shift());
        }
        if (threeLiftBackDown.includes(threeLiftTotalArray[0])) {
          console.log();
          console.log(threeLiftBackDown.shift());
        }
        if (threeLiftBackUp.includes(threeLiftTotalArray[0])) {
          console.log();
          console.log(threeLiftBackUp.shift());
        }
        console.log("Three LIft total Array"+threeLiftTotalArray)

      }
   
      if (threeLiftTotalArray.length === 0) {
        threeLiftTotalArrayUp = [];
        threeLiftFrontDown = [];
        threeLiftBackDown = [];
        threeLiftFrontUp = [];
        threeLiftBackUp = [];
        threeLiftTotalArrayDown = [];
        threeLiftDirection=''

      }



    }, 5000);

  }
  else{

    lift.style.transform = `translateY(${floor * -100}px)`;
    lift.style.opacity = '1';
    fourOpacFade = setTimeout(() => {


      document.getElementById(`lift-floor-button-four--${floor}`).style.backgroundColor = '#EFEFEF';
      if (fourLiftTotalArray.length !== 0) {
        moveLift(fourLiftPos = fourLiftTotalArray.shift(), 'four')

        if (fourLiftFrontDown.includes(fourLiftTotalArray[0])) {
          console.log();
          console.log(fourLiftFrontDown.shift());
        }
        if (fourLiftFrontUp.includes(fourLiftTotalArray[0])) {
          console.log();
          console.log(fourLiftFrontUp.shift());
        }
        if (fourLiftBackDown.includes(fourLiftTotalArray[0])) {
          console.log();
          console.log(fourLiftBackDown.shift());
        }
        if (fourLiftBackUp.includes(fourLiftTotalArray[0])) {
          console.log();
          console.log(fourLiftBackUp.shift());
        }
        console.log(fourLiftTotalArray)

      }
      if (fourLiftTotalArray.length === 0) {
        fourLiftTotalArrayUp = [];
        fourLiftFrontDown = [];
        fourLiftBackDown = [];
        fourLiftFrontUp = [];
        fourLiftBackUp = [];
        fourLiftTotalArrayDown = [];
        fourLiftDirection=''
      }




    }, 5000);
  }

};
















const alertForLifts = () => {
  alert('There is already a lift available on this floor.');
};











const moveLiftWithControls = (index, side) => {
  let lift = document.querySelector(`.lift--${side}`);
  if (side === 'left') {
 
   

    clearTimeout(leftOpacFade);
  

  }






  else if(side==='right'){

    clearTimeout(rightOpacFade);
  }
  else if(side==='three')
  {
    clearTimeout(threeOpacFade);
  }
  else if(side==='four')
  {
    clearTimeout(fourOpacFade)
  }
    moveLift(index,side)




}















const functionalityHandler = (e) => {
  console.clear();
  console.log(leftLiftTotalArray)
  console.log(e.target.id)
  for (let index = numOfFloors; index >= 0; index--) {

    if (e.target.classList.contains(`call-button--${index}-up`) || e.target.classList.contains(`call-button--${index}-down`)) {
      console.log(e.target.id)
      currentPos = index;
    


      


    










    }

    switch (e.target.id) {
      case `lift-floor-button-left--${index}`:

        document.getElementById(`lift-floor-button-left--${index}`).style.backgroundColor = 'Red';


        currentPos = index;
    

        leftLiftSort(index);


        break;


      case `lift-floor-button-right--${index}`:
        document.getElementById(`lift-floor-button-right--${index}`).style.backgroundColor = 'Red';
        currentPos = index;
      



        rightLiftSort(index);
        break;
        case `lift-floor-button-three--${index}`:
          console.log("Hello")
          document.getElementById(`lift-floor-button-three--${index}`).style.backgroundColor = 'Red';
          currentPos = index;
  
  
        threeLiftSort(index);
  
        
          break;
          case `lift-floor-button-four--${index}`:
            document.getElementById(`lift-floor-button-four--${index}`).style.backgroundColor = 'Red';
            currentPos = index;
      
           fourLiftSort(index);
    
           
            break;
    }
  }
}


functionality.addEventListener('click', functionalityHandler);


function leftLiftSort(index) {
  leftLiftArray.push(index);

  if (index - leftLiftPos > 0) {
    leftLiftDirection = "up"
  }
  else {
    leftLiftDirection = "down"
  }
  if (leftLiftDirection === "up") {

    if (leftLiftPos < index) {
      leftLiftFrontUp.push(index);
      leftLiftFrontUp.sort(function (a, b) { return a - b });
    }
    else {
      leftLiftBackUp.push(index);
      leftLiftBackUp.sort(function (a, b) { return b - a });
    }
  

    leftLiftTotalArrayUp = leftLiftFrontUp.concat(leftLiftBackUp);
  }
  else {



    if (leftLiftPos < index) {
      leftLiftFrontDown.push(index);
      leftLiftFrontDown.sort(function (a, b) { return a - b });
    }
    else {


      leftLiftBackDown.push(index)
      leftLiftBackDown.sort(function (a, b) { return b - a; })
    }
    


    leftLiftTotalArrayDown = leftLiftBackDown.concat(leftLiftFrontDown);
  }

  if (leftLiftDirection === "up") {
    leftLiftTotalArray = leftLiftTotalArrayDown.concat(leftLiftTotalArrayUp);

    moveLiftWithControls(leftLiftTotalArray[0], 'left');


  }
  else {


    leftLiftTotalArray = leftLiftTotalArrayUp.concat(leftLiftTotalArrayDown);

    moveLiftWithControls(leftLiftTotalArray[0], 'left');






  }
}





function rightLiftSort(index) {
  rightLiftArray.push(index);


  if (index - rightLiftPos > 0) {
    rightLiftDirection = "up"
  }
  else {
    rightLiftDirection = "down"
  }
  if (rightLiftDirection === "up") {

    if (rightLiftPos < index) {
      rightLiftFrontUp.push(index);
      rightLiftFrontUp.sort(function (a, b) { return a - b });
    }
    else {
      rightLiftBackUp.push(index);
      rightLiftBackUp.sort(function (a, b) { return b - a });
    }
    console.log("rightLiftFrontUp" + rightLiftFrontUp);
    console.log("rightLiftBackUp" + rightLiftBackUp);
    console.log("")

    rightLiftTotalArrayUp = rightLiftFrontUp.concat(rightLiftBackUp);
  }
  else {



    if (rightLiftPos < index) {
      rightLiftFrontDown.push(index);
      rightLiftFrontDown.sort(function (a, b) { return a - b });
    }
    else {


      rightLiftBackDown.push(index)
      rightLiftBackDown.sort(function (a, b) { return b - a; })
    }
    console.log("rightLiftFrontDown" + rightLiftFrontDown)
    console.log("rightLiftBackDown" + rightLiftBackDown)


    rightLiftTotalArrayDown = rightLiftBackDown.concat(rightLiftFrontDown);
  }

  if (rightLiftDirection === "up") {
    rightLiftTotalArray = rightLiftTotalArrayDown.concat(rightLiftTotalArrayUp);

    moveLiftWithControls(rightLiftTotalArray[0], 'right');


  }
  else {


    rightLiftTotalArray = rightLiftTotalArrayUp.concat(rightLiftTotalArrayDown);

    moveLiftWithControls(rightLiftTotalArray[0], 'right');






  }
}








function threeLiftSort(index) {
  threeLiftArray.push(index);


  if (index - threeLiftPos > 0) {
    threeLiftDirection = "up"
  }
  else {
    threeLiftDirection = "down"
  }
  if (threeLiftDirection === "up") {

    if (threeLiftPos < index) {
      threeLiftFrontUp.push(index);
      threeLiftFrontUp.sort(function (a, b) { return a - b });
    }
    else {
      threeLiftBackUp.push(index);
      threeLiftBackUp.sort(function (a, b) { return b - a });
    }
    console.log("threeLiftFrontUp" + threeLiftFrontUp);
    console.log("threeLiftBackUp" + threeLiftBackUp);
    console.log("")

    threeLiftTotalArrayUp = threeLiftFrontUp.concat(threeLiftBackUp);
  }
  else {



    if (threeLiftPos < index) {
      threeLiftFrontDown.push(index);
      threeLiftFrontDown.sort(function (a, b) { return a - b });
    }
    else {


      threeLiftBackDown.push(index)
      threeLiftBackDown.sort(function (a, b) { return b - a; })
    }
    console.log("threeLiftFrontDown" + threeLiftFrontDown)
    console.log("threeLiftBackDown" + threeLiftBackDown)


    threeLiftTotalArrayDown = threeLiftBackDown.concat(threeLiftFrontDown);
  }

  if (threeLiftDirection === "up") {
    threeLiftTotalArray = threeLiftTotalArrayDown.concat(threeLiftTotalArrayUp);

    moveLiftWithControls(threeLiftTotalArray[0], 'three');


  }
  else {


    threeLiftTotalArray = threeLiftTotalArrayUp.concat(threeLiftTotalArrayDown);

    moveLiftWithControls(threeLiftTotalArray[0], 'three');






  }
}


function fourLiftSort(index) {
  fourLiftArray.push(index);


  if (index - fourLiftPos > 0) {
    fourLiftDirection = "up"
  }
  else {
    fourLiftDirection = "down"
  }
  if (fourLiftDirection === "up") {

    if (fourLiftPos < index) {
      fourLiftFrontUp.push(index);
      fourLiftFrontUp.sort(function (a, b) { return a - b });
    }
    else {
      fourLiftBackUp.push(index);
      fourLiftBackUp.sort(function (a, b) { return b - a });
    }
    console.log("fourLiftFrontUp" + fourLiftFrontUp);
    console.log("fourLiftBackUp" + fourLiftBackUp);
    console.log("")

    fourLiftTotalArrayUp = fourLiftFrontUp.concat(fourLiftBackUp);
  }
  else {



    if (fourLiftPos < index) {
      fourLiftFrontDown.push(index);
      fourLiftFrontDown.sort(function (a, b) { return a - b });
    }
    else {


      fourLiftBackDown.push(index)
      fourLiftBackDown.sort(function (a, b) { return b - a; })
    }
    console.log("fourLiftFrontDown" + fourLiftFrontDown)
    console.log("fourLiftBackDown" + fourLiftBackDown)


    fourLiftTotalArrayDown = fourLiftBackDown.concat(fourLiftFrontDown);
  }

  if (fourLiftDirection === "up") {
    fourLiftTotalArray = fourLiftTotalArrayDown.concat(fourLiftTotalArrayUp);

    moveLiftWithControls(fourLiftTotalArray[0], 'four');


  }
  else {


    fourLiftTotalArray = fourLiftTotalArrayUp.concat(fourLiftTotalArrayDown);

    moveLiftWithControls(fourLiftTotalArray[0], 'four');






  }
}

