export class Rectangle {

  private width : number;
  private height : number;

  constructor(width: number, height: number) {
      this.width = width;
      this.height = height;
  }

  getArea() : number {
    return this.width * this.height;
  }

}
