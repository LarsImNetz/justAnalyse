
describe('Arrow Function Tests', function() {

  function containsAll(array, ...elements) {
    for (let i = 0; i < elements.length; i++) {
      if (array.indexOf(elements[i]) === -1){
        return false;
      }
    }
    return true;
  }


  it('Call function with rest parameter', function() {
    const people = ['John', 'Jane', 'Bob'];
    const colleagues = ['Bob', 'Lisa'];

    expect(containsAll(people, 'Jane', 'Bob')).toBeTruthy();
    expect(containsAll(people, 'Jane', 'Lisa')).toBeFalsy();

    expect(containsAll(people, ...colleagues)).toBeFalsy();
  });

  it('array.push with an other array', () => {
    const peopleIKnow = ['John', 'Jane'];
    const colleagues = ['Bob', 'Lisa'];

    peopleIKnow.push(...colleagues);

    expect(peopleIKnow.length).toEqual(4);
    expect(peopleIKnow[3]).toEqual("Lisa");
  })

  it('new array with other arrays',()=>{
    const family = ['Mom', 'Dad', 'Susi'];
    const friends = ['Steve', 'Mary'];

    const inviteToParty = ['John', ...family, ...friends, 'Bob'];

    expect(inviteToParty.length).toEqual(7);
  });

});

