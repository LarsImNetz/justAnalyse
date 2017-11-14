
describe('Arrow Function Tests', function() {

  it('normale anonyme Funktion', function() {
    const squares = function(elem) {return elem * elem;};

    expect(squares(726)).toEqual(527076);
  });

  it('Arrow function', function() {
    const squares = (elem) => {return elem * elem;};

    expect(squares(4)).toEqual(16);
  });

  it('Arrow function short', function() {
    const squares = elem => elem * elem;

    expect(squares(4)).toEqual(16);
  });

});

