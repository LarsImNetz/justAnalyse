import {Rectangle} from './Rectangle';

describe('Rectangle tests', () => {


  beforeEach(()=>{
  });

  it('should be that there is a getArea() function', () => {
    let rectangle: Rectangle;
    rectangle = new Rectangle(20,30);

    expect(rectangle.getArea()).toEqual(600);
  });
});
