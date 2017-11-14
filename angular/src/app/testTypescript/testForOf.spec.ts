import {async, ComponentFixture, TestBed} from '@angular/core/testing';

describe('for of tests', () => {

  it('for of', () => {
    const players = ['Luke', 'Laia'];
    let result = "";
    for (const player of players) {
      result += `${player} `;
    }

    expect(result).toEqual("Luke Laia ");
  });
});

