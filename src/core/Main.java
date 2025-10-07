package core;

import utils.Roll;
import java.util.Scanner;
import models.Personagem;
import models.Inimigo;

public class Main {
    public static void main(String[] args) {
        // Criação do personagem
        Personagem jogador = CriadorDePersonagem.criarPersonagem();
        Inimigo MeioOrc = new Inimigo("Orc Brutal", 16, 4, 14);
        Inimigo Capanga1 = new Inimigo("Capanga 1", 8, 0, 10);
        Inimigo Capanga2 = new Inimigo("Capanga 2", 7, 0, 10);

        Scanner scanner = new Scanner(System.in);
        
        // Início da aventura
        System.out.println("\n" + jogador.getNome() + " acorda em um quarto escuro, com cheiro de mofado. Você está deitado em uma confortável cama, mas em um ambiente que não reconhece.");
        System.out.println("Antes que consiga despertar, ouve uma voz, fina e um pouco estridente, exclamando: \"Ah, você finalmente acordou! Achei que tinha passado dessa pra melhor, lhe trouxeram aqui completamente esfarrapado, amigo.\" Você não recorda a identidade deste gnomo que aparece ao lado da cama em que está, nem este ambiente. Este gnomo, de pele pálida, olhos esbugalhados e cabelo grisalho ralo, começa a derramar tinturas e tônicos em você, o que faz seu corpo lembrar da aparente surra que tomou - pois seus ossos e feridas ardem em resposta às poções. Você então pergunta o nome deste indivíduo, que responde: \"Meu nome é Quoro, sou o curandeiro desta pequena vila de Valmira.\". Você se apresenta e pergunta se Quoro sabe alguma coisa dos indivíduos que lhe atacaram, ou que circunstâncias levaram você ao quarto do curandeiro.");
        System.out.println("Ele diz: \"Eu não sei nada sobre o acontecido jovem, a Dona Jandra, taverneira do \\\"Tronco Oco\\\", foi quem lhe trouxe às pressas para cá, nem tive tempo de perguntar nada a ela.\"");
        System.out.println("Você pergunta mais sobre a Dona Jandra, mas ela aparenta apenas ser uma comerciante local com uma pequena taverna. Logo, suas forças são magicamente restauradas por Quoro, e você se levanta, determinado a descobrir o que lhe levou à pequena vila de Valmira e quem lhe atacou, e procurando saber o que Dona Jandra sabe sobre o caso.");
        System.out.println("Após agradecer o velho gnomo pela ajuda, você sai de sua humilde porém aconchegante estadia para as ruas de um vilarejo medieval, cujas ruas de terra estão marcadas pelos passos de cidadãos e rodas de carruagens. Algumas estruturas mais chamativas são a praça local, o armazém e a bela taverna \\\"Tronco Oco\\\".");
        
        boolean sabeCavaleiros = false;
        boolean saiuDaTaverna = false;

        // Loop de exploração
        while (!saiuDaTaverna) {
            // Primeira escolha do jogador
            System.out.println("Para qual local deseja ir? 1 para Praça Local; 2 para Armazém; 3 para Taverna;");
            int escolhaLocal = scanner.nextInt();

            switch (escolhaLocal) {
                case 1:
                    // Praça Local
                    System.out.println("\nNa praça local, você pode ver alguns cidadãos reunidos em comércio simples e conversando. Escolha uma ação (1, 2, 3, 4):");
                    System.out.println("1 - Tentar observar algo notável no ambiente. (Sab)");
                    System.out.println("2 - Ouvir as conversas locais.");
                    System.out.println("3 - Ouvir um sermão religioso.");
                    System.out.println("4 - Sair.");

                    int acaoPraça = scanner.nextInt();

                    switch (acaoPraça) {
                        case 1:
                            if ((Roll.d20() + jogador.getSabedoria()) >= 12) {
                                System.out.println("- Você consegue ver indivíduos que parecem cochichar sobre você, mas que desviam o olhar ao ver que você os percebeu.");
                            } else {
                                System.out.println("- Você não notou nada demais");
                            }
                            break;
                        case 2:
                            System.out.println("- Você passa um tempo ouvindo os dois cidadãos discutirem sobre o preço de uma galinha que está sendo negociada. Depois da intrigante conversa, nota que está apenas perdendo tempo.");
                            break;
                        case 3:
                            System.out.println("- Você decidiu ouvir um elfo falar sobre a grandeza de Pelor, até que o grupo de pessoas interessadas começa a retirar e o pregador se retira, derrotado.");
                            break;
                        case 4:
                            System.out.println("- Você decide sair da praça.");
                            break;
                        default:
                            System.out.println("- Opção inválida.");
                    }
                    break;

                case 2:
                    // Armazém
                    System.out.println("\nAo chegar no armazém, uma placa simplesmente diz: Fechado por ordem dos Cavaleiros do Ermo.");

                    if ((Roll.d20() + jogador.getInteligencia()) >= 15) {
                        System.out.println("Os Cavaleiros do Ermo são um grupo de saqueadores que se organizou em uma pequena milícia, e agora faz trabalhos para a poderosa Igreja de Pelor. Você desconhece o por quê de eles terem fechado esta loja.");
                        sabeCavaleiros = true;
                    }
                    break;

                case 3:
                    // Taverna
                    System.out.println("\nEntrando na taverna \\\"Tronco Oco\\\", você pode ver diversos indivíduos se alimentando e bebendo, porém reservados ao seus próprios grupos ou às sós. Em contraste a eles, uma anã simpática de cabelos curtos e avermelhados bebe de um grande copo de madeira. Ao ver você se aproximando, ela diz, em uma voz forte e imponente: \\\"Opa meu camarada acamado! Voltou a andar rápido não foi? Aquele Quoro é realmente mágico quando se trata de ferimentos!\\\"");

                    if (jogador.getForca() <= 0) {
                        System.out.println("O aperto de mão dela lhe desequilibra, e ela exclama: \"Você ainda precisa de mais tempo pra recuperar suas forças!\"");
                    }

                    System.out.println("Você retribui os calorosos cumprimentos, e ela aperta sua mão com vigor. Você se apresenta, ela se apresenta como Jandra, e após alguns minutos de conversa jogada fora, você pergunta a ela o que ela sabe do que aconteceu, e que você não se lembra de nada que houve e que lhe levou até aí. A aparência cordial de Jandra se desfaz, sendo substituída por um leve olhar de preocupação.");

                    System.out.println("Como você deseja abordar a situação? (Digite 1; 2; 3)");
                    System.out.println("1 - Tentar intimidá-la sutilmente a dizer a verdade, flexionando seus músculos. (For)");
                    System.out.println("2 - Tentar convencê-la que você é um indivíduo confiável e que ela pode contar tudo para você. (Car)");
                    System.out.println("3 - Usar sua intuição e leitura de pessoas para entender a preocupação dela. (Sab)");

                    int abordagem = scanner.nextInt();
                    boolean sucesso = false;
                    boolean vantagem = false;

                    // Verificar se tem vantagem
                    if (abordagem == 3 && (Roll.d20() + jogador.getSabedoria()) > 10) {
                        vantagem = true;
                        System.out.println("Você consegue ler a preocupação genuína de Jandra e ganha vantagem para descobrir o que ela está escondendo!");
                    }
                    if (sabeCavaleiros) {
                        vantagem = true;
                        System.out.println("Seu conhecimento sobre os Cavaleiros do Ermo lhe dá vantagem!");
                    }

                    if (abordagem == 1) {
                        int rollForca = (Roll.d20() + jogador.getForca());
                        
                        if (vantagem) {
                            rollForca += 2;
                        }

                        if (rollForca > 14) {
                            System.out.println("Jandra: Tudo bem, tudo bem, eu vou dizer a verdade! Você tinha entrado no armazém, que aqueles cavaleiros esquisitos usam como base de operações. Eu vi você entrar lá, e chamei o Ravnil, patrulheiro da cidade para lhe resgatar. Ravnil o trouxe a mim, e eu lhe levei ao curandeiro. Não precisamos apelar para a violência!!");
                            sucesso = true;

                        } else {
                            System.out.println("Teste falhado!");
                        }

                    } else if (abordagem == 2) {
                        int rollCarisma = (Roll.d20() + jogador.getCarisma());
                        
                        if (vantagem) {
                            rollCarisma += 2;
                        }

                        if (rollCarisma > 14) {
                            System.out.println("Jandra: Tudo bem, tudo bem, eu vou dizer a verdade! Você tinha entrado no armazém, que aqueles cavaleiros esquisitos usam como base de operações. Eu vi você entrar lá, e chamei o Ravnil, patrulheiro da cidade para lhe resgatar. Ravnil o trouxe a mim, e eu lhe levei ao curandeiro. Sabia que você era uma pessoa confiável!");
                            sucesso = true;

                        } else {
                            System.out.println("Teste falhado!");
                        }

                    } else if (abordagem == 3) {
                        if ((Roll.d20() + jogador.getSabedoria()) > 10) {
                            System.out.println("Você percebe que Jandra está genuinamente preocupada com sua segurança.");

                        } else {
                            System.out.println("Teste falhado!");
                        }
                    }

                    if (!sucesso && (abordagem == 1 || abordagem == 2 || abordagem == 3)) {
                        System.out.println("Você sai frustrado da conversa, mas antes de sair, Jandra diz: \"" + jogador.getNome() + "! Procure por Ravnil, ele fica nos muros guardando a cidade, ele poderá lhe dizer mais.\"");
                    }

                    // Sai do loop de exploração ao sair da taverna
                    saiuDaTaverna = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        
        // Segunda parte da aventura
        System.out.println("\nVocê sai da taverna, você deseja: Checar o armazém (1) ou Falar com Ravnil (2)?");
        int segundaEscolha = scanner.nextInt();
        
        if(segundaEscolha == 1 && !sabeCavaleiros) {
            System.out.println("\nAo chegar no armazém, uma placa simplesmente diz: Fechado por ordem dos Cavaleiros do Ermo.");
            if ((Roll.d20() + jogador.getInteligencia()) > 15) {
                System.out.println("Os Cavaleiros do Ermo são um grupo de saqueadores que se organizou em uma pequena milícia, e agora faz trabalhos para a poderosa Igreja de Pelor. Você desconhece o por quê de eles terem fechado esta loja.");
            
            } else {
                System.out.println("Você decide procurar por Ravnil.");

                System.out.println("\nAo procurar por Ravnil nos muros da cidade e perguntar pela localização dele para alguns dos guardas, você finalmente conhece um humano, de cabelos negros bem escovados para trás, um tapa-olho por cima do olho esquerdo e usando uma bonita armadura. Ao ver você, ele fala, com uma voz séria e rouca: \"Você se recuperou. Ainda bem, quando lhe achei o seu estado estava... enfim, o que quer agora?\"");
                System.out.println("Você explica que quer encontrar os indivíduos que foram tão violentos, e ele lhe interrompe e adiciona: \"Justamente, espero que você não esteja pensando que vai ganhar de todos eles só, entrando e atacando sem pensar. Eu não poderei lhe ajudar da próxima vez, não posso deixar meu posto. Eles ainda estão no armazém. Agora vá, faça o que precisa fazer, e boa sorte.\" Você agradece Ravnil por ter lhe salvado, e pelos conselhos dados, mesmo que de maneira direta e meio seca.");
                System.out.println("Após ouvir o que Ravnil tinha a dizer, você vai a caminho do armazém, determinado a acertar as contas!");
            }

        } else if (segundaEscolha == 2) {
            System.out.println("\nAo procurar por Ravnil nos muros da cidade e perguntar pela localização dele para alguns dos guardas, você finalmente conhece um humano, de cabelos negros bem escovados para trás, um tapa-olho por cima do olho esquerdo e usando uma bonita armadura. Ao ver você, ele fala, com uma voz séria e rouca: \"Você se recuperou. Ainda bem, quando lhe achei o seu estado estava... enfim, o que quer agora?\"");
            System.out.println("Você explica que quer encontrar os indivíduos que foram tão violentos, e ele lhe interrompe e adiciona: \"Justamente, espero que você não esteja pensando que vai ganhar de todos eles só, entrando e atacando sem pensar. Eu não poderei lhe ajudar da próxima vez, não posso deixar meu posto. Eles ainda estão no armazém. Agora vá, faça o que precisa fazer, e boa sorte.\" Você agradece Ravnil por ter lhe salvado, e pelos conselhos dados, mesmo que de maneira direta e meio seca.");
            System.out.println("Após ouvir o que Ravnil tinha a dizer, você vai a caminho do armazém, determinado a acertar as contas!");
        }

        
        // Terceira parte - entrada no armazém
        System.out.println("\nVocê tenta entrar no armazém, como aborda? (Digite 1; ou 2; ou 3)");
        System.out.println("1 - Derrubar a porta.");
        System.out.println("2 - Bater e esperar alguém abrir.");
        System.out.println("3 - Procurar uma entrada alternativa.");
        
        int entradaArmazem = scanner.nextInt();
        
        switch (entradaArmazem) {
            case 1:
                System.out.println("\nVocê derruba a porta, alertando um guarda que estava logo atrás dela, que grita e parte para cima para lhe atacar!!!");
                System.out.println("Combate começa.");
                Combate.combateTurnos(jogador, Capanga1, scanner);
                System.out.println("Após derrotar o primeiro capanga, outro aparece para lhe atacar!!");
                Combate.combateTurnos(jogador, Capanga2, scanner);
                System.out.println("Após derrotar o segundo capanga, surge na sua frente o imponente chefe dos bandidos, um meio Orc GIGANTE e FURIOSO!!!");
                Combate.combateTurnos(jogador, MeioOrc, scanner);
                System.out.println("Após sua vitória, você encontra documentos que comprovam que os Cavaleiros do Ermo iriam atacar a vila de Valmira em breve, e assim, você salva a vila!");
                System.out.println("Parabéns, você chegou ao fim do jogo");
                System.exit(0);
                break;
                
            case 2:
                System.out.println("\nUm guarda abre e diz: \"Você é muito corajoso, ou muito burro, de ter aparecido aqui de novo!\"");
                if ((Roll.d20() + jogador.getCarisma()) > 12) {
                    System.out.println("Você convence o guarda que sua coragem é admirável, e eles lhe levam para dentro do covil. Lá dentro, você vê o chefe dos bandidos, um Meio-Orc forte, sentado com as pernas cruzadas por cima da mesa do antigo armazém, que agora guarda o saque que eles acumularam.");
                    
                    System.out.println("Escolha (Digite 1 ou 2)");
                    System.out.println("1 - Começar combate com o chefe");
                    System.out.println("2 - Tentar rapidamente jogar uma mochila de saque próxima no chefe (Des)");
                    
                    int escolhaChefe = scanner.nextInt();
                    
                    if (escolhaChefe == 1) {
                        System.out.println("Combate com o chefe começa!");
                        Combate.combateTurnos(jogador, MeioOrc, scanner);
                        System.out.println("Ao verem seu chefe cair, os capangas fogem pela porta da frente, deixando você sozinho no armazém.");
                        System.out.println("Após sua vitória, você encontra documentos que comprovam que os Cavaleiros do Ermo iriam atacar a vila de Valmira em breve, e assim, você salva a vila!");
                        System.out.println("Parabéns, você chegou ao fim do jogo.");
                        System.exit(0);
                        
                    } else if (escolhaChefe == 2) {
                        if ((Roll.d20() + jogador.getDestreza()) > 12) {
                            System.out.println("O chefe é desnorteado pela avalanche de itens!! Uma espada sai voando e acerto o olho dele, que grita de dor e raiva!!");
                            MeioOrc.setPV(MeioOrc.getPV() - 3);
                            Combate.combateTurnos(jogador, MeioOrc, scanner);
                            System.out.println("Ao verem seu chefe cair, os capangas fogem pela porta da frente, deixando você sozinho no armazém.");
                            System.out.println("Após sua vitória, você encontra documentos que comprovam que os Cavaleiros do Ermo iriam atacar a vila de Valmira em breve, e assim, você salva a vila!");
                            System.out.println("Parabéns, você chegou ao fim do jogo.");
                            System.exit(0);

                        } else {
                            System.out.println("Você derruba uma garrafa de óleo flamejante em seus pés e escorrega, caindo no chão. Você perde 3 PV.");
                            jogador.setPV(jogador.getPV() - 3);
                            Combate.combateTurnos(jogador, MeioOrc, scanner);
                            System.out.println("Ao verem seu chefe cair, os capangas fogem pela porta da frente, deixando você sozinho no armazém.");
                            System.out.println("Após sua vitória, você encontra documentos que comprovam que os Cavaleiros do Ermo iriam atacar a vila de Valmira em breve, e assim, você salva a vila!");
                            System.out.println("Parabéns, você chegou ao fim do jogo.");
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("O guarda não acredita em você, e grita por reforços, um guarda lhe ataca!!!");
                    System.out.println("Combate começa.");
                    Combate.combateTurnos(jogador, Capanga1, scanner);
                    System.out.println("Após derrotar o primeiro capanga, outro aparece para lhe atacar!!");
                    Combate.combateTurnos(jogador, Capanga2, scanner);
                    System.out.println("Após derrotar o segundo capanga, surge na sua frente o imponente chefe dos bandidos, um meio Orc GIGANTE e FURIOSO!!!");
                    Combate.combateTurnos(jogador, MeioOrc, scanner);
                    System.out.println("Após sua vitória, você encontra documentos que comprovam que os Cavaleiros do Ermo iriam atacar a vila de Valmira em breve, e assim, você salva a vila!");
                    System.out.println("Parabéns, você chegou ao fim do jogo");
                    System.exit(0);
                }
                break;
                
            case 3:
                System.out.println("\n\"Não tem entrada alternativa :D\"");
                System.out.println("Parabéns, você chegou ao fim do jogo");
                break;
                
            default:
                System.out.println("Opção inválida.");
        }
        
        scanner.close();
    }
}