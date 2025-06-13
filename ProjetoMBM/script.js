// Mobile menu toggle
const menuToggle = document.getElementById('menuToggle');
const mobileMenu = document.getElementById('mobileMenu');
const closeMenu = document.getElementById('closeMenu');

menuToggle.addEventListener('click', () => {
  mobileMenu.classList.remove('hidden');
});

closeMenu.addEventListener('click', () => {
  mobileMenu.classList.add('hidden');
});

// Fechar menu ao clicar num link
document.querySelectorAll('#mobileMenu a').forEach(link => {
  link.addEventListener('click', () => {
    mobileMenu.classList.add('hidden');
  });
});

// Scroll para o topo
const scrollTopBtn = document.getElementById('scrollTopBtn');

window.addEventListener('scroll', () => {
  if (window.scrollY > window.innerHeight / 2) {
    scrollTopBtn.style.display = 'block';
  } else {
    scrollTopBtn.style.display = 'none';
  }
});

scrollTopBtn.addEventListener('click', () => {
  window.scrollTo({ top: 0, behavior: 'smooth' });
});



// Ficha exercicios javaScript

// Declaração de variáveis
let nome = "Andreia";
let apelido = "Guedes";
let idade = 38;
let email = "martins.andreiad@gmail.com";

// Mostrar info em MAIÚSCULAS
console.log("Nome: " + nome.toUpperCase());
console.log("Apelido: " + apelido.toUpperCase());
console.log("Idade: " + idade);
console.log("Email: " + email);

// Função para contar caracteres
function contarCaracteres(texto) {
  return texto.length;
}

console.log("Nome: " + nome + " (" + contarCaracteres(nome) + ")");
console.log("Apelido: " + apelido + " (" + contarCaracteres(apelido) + ")");

// Nova função transformarTexto 
function transformarTexto(nome, apelido) {
  console.log(nome.toUpperCase());
  console.log(apelido.toUpperCase());

  console.log(nome.toLowerCase());
  console.log(apelido.toLowerCase());
}

transformarTexto(nome, apelido);

function primeiraOcorrencia(letra, frase) {
  let array = frase.split("");
  let i = array.indexOf(letra);
  return array[i].toUpperCase().repeat(3);
}

function ultimaOcorrencia(letra, frase) {
  let array = frase.split("");
  let i = array.lastIndexOf(letra);
  return array[i].toUpperCase().repeat(3);
}

let texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean bibendum fermentum.";

console.log("Primeira ocorrência da letra 'a': " + primeiraOcorrencia("a", texto));
console.log("Última ocorrência da letra 'b': " + ultimaOcorrencia("b", texto));

//math.random
console.log(Math.random());

