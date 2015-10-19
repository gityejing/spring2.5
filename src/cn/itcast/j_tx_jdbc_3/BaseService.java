package cn.itcast.j_tx_jdbc_3;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false)
public class BaseService {

}
