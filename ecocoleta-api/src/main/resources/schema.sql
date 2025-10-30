--criação enum=--
Create type Perfil_Enum AS ENUM(
	'RESIDENCIAL',
	'COLETOR'
);

Create type Status_Enum AS ENUM(
	'AGUARDANDO',
	'COLETADA',
	'FINALIZADA',
	'CANCELADA'
);

Create type Tipo_Enum AS ENUM(
	'PLASTICO',
	'VIDRO', 
	'PAPEL', 
	'METAL'
);

Create type Estado_Enum AS ENUM(
	'RUIM', 
	'BOM', 
	'OTIMO'
);

Create table if not exists usuario(
	--identificação e acesso--
	id BIGSERIAL PRIMARY KEY,
	nome_usuario varchar(150) not null unique,
	senha varchar(60) not null,
	perfil Perfil_Enum not null,

	--endereço--
	cep varchar (8) not null,
	logradouro varchar(255) not null,
	estado varchar(2) not null,
	cidade varchar(100) not null,
	bairro varchar(100) not null,
	numero varchar(10) not null,
	complemento varchar(100),
	latitude numeric(9,7),
	longitude numeric (10,7)
);


Create table if not exists solicitacao_coleta(
	id BIGSERIAL PRIMARY KEY,
	status Status_Enum not null default 'AGUARDANDO',
	data_solicitacao TIMESTAMP WITH TIME ZONE not null,
	data_agenda date not null,
	observacoes varchar(100),
	feedback varchar(100),
	usuario_residencial_id BIGINT NOT NULL,
		CONSTRAINT fk_solicitacao_residencial
		FOREIGN KEY (usuario_residencial_id)
		REFERENCES usuario(id),
	usuario_coletor_id BIGINT,
		CONSTRAINT fk_solicitacao_coletor
		FOREIGN KEY (usuario_coletor_id)
		REFERENCES usuario(id)
);

Create table item_coleta(
	id BIGSERIAL PRIMARY KEY,
	tipo_material Tipo_Enum not null,
	quantidade_estimada NUMERIC (10,2) not null,
	quantidade_validada numeric (10,2) not null,
	estado Estado_Enum not null,
	solicitacao_coleta_id BIGINT not null,
		CONSTRAINT fk_itemcoleta_solicitacao
		FOREIGN KEY (solicitacao_coleta_id)
		REFERENCES solicitacao_coleta(id)
);
