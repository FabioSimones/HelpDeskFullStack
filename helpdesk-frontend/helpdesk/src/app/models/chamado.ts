export interface Chamado{
    id?: any;
    dataAbertura?: string;
    dataFechamento?: string;
    status: string;
    prioridade: string;
    titulo?: string;
    descricao: string;
    tecnico: any;
    cliente: any;
    nomeCliente: string;
    nomeTecnico: string;
}