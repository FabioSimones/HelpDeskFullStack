export interface Chamado{
    id?: any;
    dataAbertura?: string;
    dataFechamento?: string;
    status: string;
    prioridade: string;
    titulo?: string;
    observacoes: string;
    tecnico: any;
    cliente: any;
    nomeCliente: string;
    nomeTecnico: string;
}