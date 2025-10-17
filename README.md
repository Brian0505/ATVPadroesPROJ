
# Aluno: Brian Cristian Cavalheiro 

# Sistema de Integração de Mídias Sociais

Este projeto implementa um sistema unificado para agendamento e publicação de conteúdo em múltiplas redes sociais, utilizando padrões de projeto para criar uma arquitetura flexível e escalável.

## Arquitetura e Padrões de Projeto

A solução foi construída utilizando uma combinação de três padrões de projeto principais para atender aos requisitos de flexibilidade, desacoplamento e extensibilidade.


### Diagrama de Classes (UML)

```mermaid
classDiagram
    class GerenciadorMidiaSocial {
        <<Cliente>>
        main()
    }

    class ISocialMediaAdapter {
        <<Interface>>
        +postar(conteudo: Conteudo): ApiResponse~Publicacao~
    }

    class TwitterAdapter {
        - twitterApi: TwitterApi
        +postar(conteudo: Conteudo): ApiResponse~Publicacao~
    }

    class LinkedInAdapter {
        - linkedInApi: LinkedInApi
        +postar(conteudo: Conteudo): ApiResponse~Publicacao~
    }

    class SocialMediaFactory {
        <<Factory>>
        +static criarAdapter(platform: String): ISocialMediaAdapter
    }

    class TwitterApi {
        <<API Externa>>
        +tweet(status: TwitterStatus): TwitterTweet
    }

    class LinkedInApi {
        <<API Externa>>
        +submitShare(share: LinkedInShare): LinkedInPost
    }

    class Conteudo
    class Publicacao
    class ApiResponse~T~

    GerenciadorMidiaSocial --> SocialMediaFactory : uses
    GerenciadorMidiaSocial --> ISocialMediaAdapter : uses
    SocialMediaFactory ..> ISocialMediaAdapter : creates
    ISocialMediaAdapter <|.. TwitterAdapter : implements
    ISocialMediaAdapter <|.. LinkedInAdapter : implements
    TwitterAdapter o-- TwitterApi : wraps
    LinkedInAdapter o-- LinkedInApi : wraps
```