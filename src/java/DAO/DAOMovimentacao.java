/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import Modelo.ModelCategoria;
import Modelo.ModelMovimentacao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danilo
 */
public class DAOMovimentacao implements IGestao {

    private final FabricaConexoes fabrica;

    public DAOMovimentacao() {
        fabrica = new FabricaConexoes();
    }

    @Override
    public void Save(Object parametro) {
        ModelMovimentacao mov = (ModelMovimentacao) parametro;
        Date d = new Date(mov.getData().getTime());
        try {
            Statement smt = fabrica.Connectar();
            if (smt != null) {
                String sql = ("INSERT INTO Movimentacao (id_mov,valor,"
                        + "data,"
                        + "descricao,"
                        + "id_categoria,"
                        + "status"
                        + ") VALUES ("
                        + "'" + mov.getIdMovimentacao() + "',"
                        + "'" + mov.getValor() + "',"
                        + "'" + d + "',"
                        + "'" + mov.getDescricao() + "',"
                        + "'" + mov.getIdCategoria() + "',"
                        + "'" + 1 + "'"
                        + ");");
                smt.executeUpdate(sql);

                //MensagemErro("Inserido com sucesso;");
            } else {
                //  MensagemErro("Não foi possivel conectar.");
            }
            throw new RuntimeException(fabrica.getStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            fabrica.FecharConexao();
        }
    }

    @Override
    public void Atualizar(Object parametro) {
        ModelMovimentacao mov = (ModelMovimentacao) parametro;
        Date d = new Date(mov.getData().getTime());
        try {
            Statement smt = fabrica.Connectar();
            if (smt != null) {
                String sql = ("UPDATE  Movimentacao SET "
                        + "id_mov = '" + mov.getIdMovimentacao() + "',"
                        + "valor = '" + mov.getValor() + "',"
                        + "data = '" + d + "',"
                        + "descricao = '" + mov.getDescricao() + "',"
                        + "id_categoria = '" + mov.getIdCategoria() + "'"
                        + " WHERE "
                        + "id_mov = '" + mov.getIdMovimentacao() + "'"
                        + ";");

                smt.executeUpdate(sql);
                //MensagemErro("Atualizado com sucesso;");
            } else {
                //  MensagemErro("Não foi possivel conectar.");
            }
            throw new RuntimeException(fabrica.getStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            fabrica.FecharConexao();
        }

    }

    @Override
    public void Delete(int identificador) {
        
        try {
            Statement smt = fabrica.Connectar();
            if (smt != null) {
                String sql = ("DELETE FROM Movimentacao"
                        + " WHERE "
                        + "id_mov = '" + identificador + "'"
                        + ";");

                smt.executeUpdate(sql);
                //MensagemErro("Atualizado com sucesso;");
            } else {
                //  MensagemErro("Não foi possivel conectar.");
            }
            throw new RuntimeException(fabrica.getStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            fabrica.FecharConexao();
        }

    }

    @Override
    public List<ModelMovimentacao> ObterLista() {
        List<ModelMovimentacao> listaMovimentacao = new ArrayList<>();
        try {
            Statement smt = fabrica.Connectar();
            if (smt != null) {
                ResultSet rs = smt.executeQuery("SELECT * FROM Movimentacao");

                if (!rs.next()) {
                    // msg = new NotificacaoMensagem("Arquivo não encontrado!", true);
                } else {
                    while (rs.next()) {
                        ModelMovimentacao m = new ModelMovimentacao();
                        m.setIdMovimentacao(rs.getInt("id_mov"));
                        m.setData(rs.getDate("data"));
                        m.setDescricao(rs.getString("descricao"));
                        m.setValor(rs.getFloat("valor"));
                        m.setStatus((rs.getInt("status") == 1 ));
                        DAOCategoria dc = new DAOCategoria();
                        ModelCategoria c = (ModelCategoria) dc.ObterPorId(Integer.parseInt(rs.getString("id_categoria")));

                        m.setIdCategoria(c.getIdCategoria());
                        m.setNomeCategoria(c.getNomeCategoria());

                        listaMovimentacao.add(m);
                    }
                }
            } else {
                throw new RuntimeException(fabrica.getStatus());
            }
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            fabrica.FecharConexao();
        }
        return listaMovimentacao;
    }

    @Override
    public Object ObterPorId(int identificador) {
        ModelMovimentacao m = null;
        try {
            Statement smt = fabrica.Connectar();
            if (smt != null) {
                ResultSet rs = smt.executeQuery("SELECT * FROM Movimentacao WHERE id_mov = " + identificador+";");
                while (rs.next()) {
                    m = new ModelMovimentacao();
                    m.setIdMovimentacao(rs.getInt("id_mov"));
                    m.setData(rs.getDate("data"));
                    m.setDescricao(rs.getString("descricao"));
                    m.setValor(rs.getFloat("valor"));
                    DAOCategoria dc = new DAOCategoria();
                    ModelCategoria c = (ModelCategoria) dc.ObterPorId(Integer.parseInt(rs.getString("id_categoria")));
                    m.setIdCategoria(c.getIdCategoria());
                    m.setNomeCategoria(c.getNomeCategoria());
                }
            } else {
                throw new RuntimeException(fabrica.getStatus());
            }
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            fabrica.FecharConexao();
        }
        return m;
    }
}


