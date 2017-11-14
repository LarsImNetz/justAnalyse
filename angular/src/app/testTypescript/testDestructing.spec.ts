describe('Descructing Values from objects', function () {

  it('normal', () => {
    const bestPlayers = ['John', 'Jane', 'Bob', 'Mary', 'Lisa'];

    const winner = bestPlayers[0];
    const second = bestPlayers[1];
    const third = bestPlayers[2];

    expect(winner).toEqual('John');
    expect(second).toEqual('Jane');
  });

  it('destructing array', () => {
    const bestPlayers = ['John', 'Jane', 'Bob', 'Mary', 'Lisa'];

    const [winner, second] = bestPlayers;

    expect(winner).toEqual('John');
    expect(second).toEqual('Jane');
  });

  it('destructing array', () => {
    const bestPlayers = ['John', 'Jane', 'Bob', 'Mary', 'Lisa'];

    const [winner, , third] = bestPlayers;

    expect(winner).toEqual('John');
    expect(third).toEqual('Bob');
  });

  it('object destructing', () => {
    const currentUser = {
      firstName: 'John',
      lastName: 'Doe'
    };

    const {firstName, lastName} = currentUser;

    expect(firstName).toEqual('John');
    expect(lastName).toEqual('Doe');
  });

  it('object destructing mit verschachtelten Objekten', () => {
    const currentUser = {
      firstName: 'John',
      lastName: 'Doe',
      address: {
        city: 'New York',
        postalCode: '10001'
      }
    };

    const {firstName, address: {city: usersCity}} = currentUser;

    expect(firstName).toEqual('John');
    expect(usersCity).toEqual('New York');
  });

  let add = function (a, b): number {
    return a + b;
  };

  it('should be that a function takes 2 parameter', () => {
    expect(add(1, 2)).toEqual(3);
  });

  let addWithObject = function (object): number {
    return object.a + object.b;
  };

  it('should be that a function takes an object as parameter', () => {
    const object = {a: 1, b: 2};
    expect(addWithObject(object)).toEqual(3);
  });

  let addWithDestruct = function ({a, b}): number {
    return a + b;
  };

  it('should be that a function takes a destruct as parameter', () => {
    const object = {a: 1, b: 2};
    expect(addWithDestruct(object)).toEqual(3);

    expect(addWithDestruct({a:1, b:2})).toEqual(3);
  });

});

