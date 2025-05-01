export interface Chamado{
    id?: any;
    dataAbertura?: Date;
    dataFechamento?: Date;
    status: string;
    prioridade: string;
    titulo?: string;
    descricao: string;
    tecnico: any;
    cliente: any;
    nomeCLiente: string;
    nomeTecnico: string;
}