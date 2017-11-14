

function *sequence(max) {
  let value = 1;
  while (value <= max) {
    yield value++;
  }
}

export function createSquaresWithArrayFrom() {
  const squares = Array.from(sequence(5), elem => elem * elem);
  return squares;
}
