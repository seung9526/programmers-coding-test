// 에라토스테네스의 체로 소수 목록 생성
const generatePrimes = (limit) => {
    const primes = Array(limit + 1).fill(true);
    primes[0] = primes[1] = false;

    for (let i = 2; i * i <= limit; i++) {
        if (primes[i]) {
            for (let j = i * i; j <= limit; j += i) primes[j] = false;
        }
    }
    return primes;
};

// 골드바흐 찾기
const gold = (n, primes) => {
    for (let i = n / 2; i >= 2; i--) {
        if (primes[i] && primes[n - i]) return `${i} ${n - i}`;
    }
};

// 입력 처리 및 결과 출력
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const primes = generatePrimes(10000);

console.log(
    input.slice(1).map((n) => gold(+n, primes)).join('\n')
);