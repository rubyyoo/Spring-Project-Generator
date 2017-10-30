package los.wizard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import los.ibatis.config.DBConnection;
import los.vo.DBVO;
import los.vo.UserTableVO;

@Repository
public class IGen2DaoImpl implements IGen2Dao {
	@Autowired
	private SqlMapClient client;
	@Autowired
	private DBConnection connection;
	
	@Override
	public List<UserTableVO> getPkList(DBVO dbInfo, Map<String, String> params) throws SQLException {
		this.connection.changeUserConnection(dbInfo);
 		List<UserTableVO> pkList = this.client.queryForList("MVC.getPkList", params);
		this.connection.changeAdminConnection();
		return pkList;
	}
	
}
