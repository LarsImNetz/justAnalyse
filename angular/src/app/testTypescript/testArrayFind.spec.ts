import {async, ComponentFixture, TestBed} from '@angular/core/testing';

describe('Array.find', () => {

  it('find', () => {
    let array = [1,3,7,6,2];
    let result = array.find(elem => elem > 5);

    expect(result).toEqual(7);
  });
});
