import {async, ComponentFixture, TestBed} from '@angular/core/testing';

describe('Tests for new String functions', () => {

  let string: string;

  beforeEach(()=>{
    string = "Hello really nice World";
  });

  it('should be that the length', () => {
    expect(string.length).toEqual(23);
  });

  it('should be that the string startswith', () => {
    expect(string.startsWith("Hello")).toBeTruthy();
  });

  it('should be that the string at position 6 startswith really', () => {
    expect(string.startsWith("really", 6)).toBeTruthy();
    expect(string.startsWith("really", 14)).toBeFalsy();
  });

  it('endswith', () => {
    expect(string.endsWith("Wor", string.length - 2)).toBeTruthy();
  });

  it('endswith', () => {
    expect(string.endsWith("World")).toBeTruthy();
  });

  it('includes', () => {
    expect(string.includes("really")).toBeTruthy();
  });

  it('includes', () => {
    expect(string.includes("really", 7)).toBeFalsy();
  });

});

