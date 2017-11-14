describe('Types tests', () => {

  const decimal: number = 42;
  const float: number = 42.00;
  const hex: number = 0x2A;

  it('', () => {

    expect(decimal).toEqual(42);
    expect(float).toEqual(42.00);
    expect(hex).toEqual(42);
  });

  const userName: string = 'John Doe';

  function greeter(name: string): string {
    return `Hello ${name}`;
  }

  it('', () => {
    expect(greeter(userName)).toEqual('Hello John Doe');
  });

  enum Size {Small, Medium, Large};
  const size = Size.Medium;

  it('', () => {
    expect(size).toEqual(1);
  });

  const numbers: number[] = [1, 2, 3];
  it('', () => {
    expect(numbers.length).toEqual(3);

    expect(numbers).toEqual([1, 2, 3]);
  });

  //
  let tuple: [string, number];
  tuple = ['foo', 1];


  tuple = ['foo', 2, 3, 'bar'];

});
