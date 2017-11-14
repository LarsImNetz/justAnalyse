import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {createSquaresWithArrayFrom} from './testArrayFrom';

describe('Array.from tests', () => {

  it('squares', () => {
    expect(createSquaresWithArrayFrom()).toEqual([1, 4, 9, 16, 25]);
  });
});

